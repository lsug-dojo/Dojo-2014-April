package controllers

import play.api._
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global
import org.reactivecouchbase.ReactiveCouchbaseDriver


object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }


  def test = Action {
    // get a driver instance driver    
	val driver = ReactiveCouchbaseDriver()
	// get the default bucket  
	val bucket = driver.bucket("default")

	// do something here with the default bucket  

	// shutdown the driver (only at app shutdown)
	driver.shutdown()

  	Ok("Hello Couch base!")
  }

  
}