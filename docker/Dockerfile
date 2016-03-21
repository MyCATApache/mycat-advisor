# Mycat Advisor Dockerfile

FROM index.alauda.cn/linzhiqiang/centos6
MAINTAINER anduo <anduo@qq.com>

ADD modules/ /tmp/_dt/
RUN sh /tmp/_dt/install.sh

VOLUME /opt/data-vol

#      ssh nginx tomcat zookeeper mysql mycat mycat-admin redis supervisor addon-port1 port2 port3
EXPOSE 2222  80    8080   2181    3306  8066  9066        6379  9001       9101        9102  9103

CMD ["/usr/bin/supervisord"]