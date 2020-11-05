#!/bin/bash
#
# Java app start/stop script skeleton.
#
##########################################################

# value section
##########################################################
USER="kemal.atik"
EXEC_JAR="./target/bkm-express-sim-1.0.0.jar"
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.5.jdk/Contents/Home

LOG_DIR=./logs
STDOUT="$LOG_DIR/stdout.log.`date +%Y%m%d%H%M`"

HEAP_PERCENT=40
JVM_OPTS="-server -Xloggc:$LOG_DIR/gc.log -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -XX:MaxPermSize=128m -XX:PermSize=128m"
STATUS_CHECK_INTERBAL=3

PATH=$PATH:$JAVA_HOME/bin

# required directories
DIR_LIST="$LOG_DIR"

#CLASSPATH=$APP_HOME/.
#for jar in $APP_HOME/lib/*.jar ; do
#  CLASSPATH=$CLASSPATH:$jar
#done

# function section
##########################################################
validate_user() {
  is_mac
  if [ $? -eq 1 ]; then
    return
  fi
  if [ "$USER" != `whoami` ]; then
    echo "run as $USER!!"
    exit 0
  fi
}

is_mac() {
  uname=`uname`
  if [ "x$uname" == "xDarwin" ]; then
    return 1
  else
    return 0
  fi
}


start(){
  is_alive
  if [ $? -eq 1 ];then
    echo "server is already running"
    exit 0
  fi

  memMB=`get_heap_mem`

#  java -Xmx${memMB}M -Xms${memMB}M $JVM_OPTS -jar $EXEC_JAR > $STDOUT 2>&1 &
  java -jar $EXEC_JAR > $STDOUT 2>&1 &
  echo "starting server: pid[`pgrep -f $EXEC_JAR`]"
}

stop(){
  echo "killing proccess: pid[`pgrep -f $EXEC_JAR`]"
  pkill -f $EXEC_JAR
  echo -n "sent kill signal. waiting for shutdown."
  retry=10
  i=0
  while [ $i -lt $retry ]; do
    is_alive
    if [ $? -eq 0 ]; then
      echo
      echo "server stopped successfully !!"
      return
    fi
    retry=$(($retry - 1))
    echo -n "."
    sleep $STATUS_CHECK_INTERBAL
  done
  echo
  echo "server is still running!!"
}

is_alive() {
  pid=`pgrep -f $EXEC_JAR`
  if [ "x" != "x"$pid ]; then
    return 1
  else
    return 0
  fi
}

status(){
  is_alive
  if [ $? -eq 1 ]; then
    echo "server is running... : pid[`pgrep -f $EXEC_JAR`]"
  else
    echo "server is not running..."
  fi
}

threaddump(){
  is_alive
  if [ $? -eq 0 ]; then
    echo "server is not running..."
    exit
  fi

  echo "send SIGQUIT: pid[`pgrep -f $EXEC_JAR`]"
  pkill -s SIGQUIT -f $EXEC_JAR

}

init_dir(){
  for dir in $DIR_LIST; do
    if [ ! -d $dir ];then
      mkdir -v $dir
    fi
  done
}

get_heap_mem() {
  memMB=`get_sysmem_mb`
  heap=$(($memMB * $HEAP_PERCENT / 100))
  echo $heap
}

get_sysmem_mb() {
  if [ -f /proc/meminfo ]; then
    memkb=`awk '/^MemTotal.*kB$/ { print $2; }' /proc/meminfo`
  else
    memkb=$(/usr/sbin/sysctl hw.memsize 2>/dev/null | awk -F: '{ print $2 / 1024; }');
  fi
  if ! echo $memkb | grep '^[0-9]*$' > /dev/null; then
    memkb=524288
  fi
  echo $(($memkb / 1024))
}


# main routine
validate_user
init_dir

case "$1" in
  start)
    start
    ;;
  stop)
    stop
    ;;
  status)
    status
    ;;
  restart)
    stop
    start
    ;;
  threaddump)
    threaddump
    ;;
  *)
    echo $"Usage: $0 {start|stop|status|restart|threaddump}"
    exit 1
esac
