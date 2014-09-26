##Cloud Game of Life

A simple GWT app Game of Life which can run on GAE (Google App Engine) cloud.

####Available Online:

http://cloudlifegame.appspot.com/


###Running the app

You need Java 1.7+ and Maven 3+.

	git clone https://github.com/oleksiykovtun/Cloud-Game-of-Life.git
    cd Cloud-Game-of-Life
	mvn appengine:devserver

###Deploying the app to the cloud

After specifying application ID in `src/main/webapp/WEB-INF/appengine-web.xml`, run

    mvn appengine:update
