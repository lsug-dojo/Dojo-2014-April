package controllers

import play.api._
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global
import org.reactivecouchbase.ReactiveCouchbaseDriver

// import the implicit JsObject reader and writer 
import org.reactivecouchbase.CouchbaseRWImplicits.documentAsJsObjectReader
import org.reactivecouchbase.CouchbaseRWImplicits.jsObjectToDocumentWriter
import scala.concurrent.Future
import play.api.libs.json._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def test = Action {
    // get a driver instance driver    
    val driver = ReactiveCouchbaseDriver()
    // get the default bucket  
    val bucket = driver.bucket("default")

    // creates a JSON document
    val document = Json.obj(
      "name" -> "John",
      "surname" -> "Doe",
      "age" -> 42,
      "address" -> Json.obj(
        "number" -> "221b",
        "street" -> "Baker Street",
        "city" -> "London"))

    // persist the JSON doc with the key 'john-doe', using implicit 'jsObjectToDocumentWriter' for serialization
    bucket.set[JsObject]("john-doe", document).onComplete {
      case status => println(s"Operation status : ${status.get}")
    } 

    // do something here with the default bucket  

    // shutdown the driver (only at app shutdown)
    driver.shutdown()

    Ok("Hello Couch base!")
  }

}