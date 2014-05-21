Dojo-2014-April
===============

This is a simple project to connect Play 2 (Scala) application with couchbase using reactive couch.

In order to get couchbase installed we choose a simple vagrant picked up from [this github](https://github.com/abtris/vagrant-couchbase.git). I added the files to the repo to have it easier to start it up.

Also the play 2 comes from the default activator for hello-play. 

Requirements
------------

* Play 2 & Scala or [Typesafe activator](http://www.vagrantup.com/)
* [Vagrant](http://www.vagrantup.com/) + virtual box


Set up environemnt
------------------

* start couchbase vagrant with `vagrant up`. 
 * Once this is started you have to access to http://localhost:8091/ and follow the instruction to have application working. Username / password has to be Administrator / password.
 * [optional] You can configure the other replica at http://localhost:8092/ 
* Then you have to start the play application: `play ~run`
 * You can have a simple test at http://localhost:9000/test
* That's it! Enjoy coding


