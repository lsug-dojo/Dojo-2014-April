#!/bin/bash
cd /vagrant/
file="/vagrant/couchbase-server-enterprise_x86_2.0.1.deb"
if [ -f "$file" ]
then
      echo "$file found."
else
      echo "$file not found."
      wget http://packages.couchbase.com/releases/2.0.1/couchbase-server-enterprise_x86_2.0.1.deb
fi
sudo apt-get install -y libssl0.9.8
sudo dpkg -i couchbase-server-enterprise_x86_2.0.1.deb 
         
