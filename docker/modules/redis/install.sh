#!/bin/bash

ver='2.8.13'
pkg="apache-tomcat-${ver}.tar.gz"

yum install -y curl tar make gcc wget

cd /usr/local/src && \
wget  http://download.redis.io/releases/redis-${ver}.tar.gz  && \
tar xf redis-${ver}.tar.gz && \
cd redis-${ver} && \
make && \
make install

cp etc/redis.conf /etc/redis.conf

cat > /etc/supervisord.d/redis.conf << EOF
[program:redis]
command=/usr/local/bin/redis-server /etc/redis.conf
autorestart=true
EOF
