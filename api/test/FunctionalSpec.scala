import javax.inject.Inject
import org.scalatest._
import com.google.inject.Guice
import com.google.inject.{AbstractModule}
import net.codingwell.scalaguice.{ScalaModule}


/**
  * Functional tests start a Play application internally, available
  * as `app`.
  */
class FunctionalSpec extends FunSuite with Matchers with
  OptionValues with Inside with Inspectors {

  test("Date String to Date--------------") {
    class MyModule extends AbstractModule with ScalaModule {
      override def configure(): Unit = {
        bind[String].toInstance("foo")
        bind[GuiceSpec.type].toInstance(GuiceSpec)
      }
    }

    object GuiceSpec {
      @Inject
      val s: String = null

      def get() = s
    }
    val injector = Guice.createInjector(new MyModule())

    val demo = injector.getInstance(classOf[String])
    println(demo)
    println(s"GuiceSpec.s---------------------------- = ${GuiceSpec.get}")
    //    val service = injector.getInstance(classOf[AService])
    assert("2" === "1")
  }
  //  "Guice" must {
  //    "inject into Scala objects" in {
  //      val injector = Guice.createInjector(new ScalaModule() {
  //        def configure() {
  //          bind[String].toInstance("foo")
  //          bind[GuiceSpec.type].toInstance(GuiceSpec)
  //        }
  //      })
  //      injector.getInstance(classOf[String]) must equal("foo")
  //      GuiceSpec.get must equal("foo")
  //    }
  //  }


  //
  //  "Routes" should {
  //
  //    "send 404 on a bad request" in  {
  //      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)
  //    }
  //
  //    "send 200 on a good request" in  {
  //      route(app, FakeRequest(GET, "/")).map(status(_)) mustBe Some(OK)
  //    }
  //
  //  }
  //
  //  "HomeController" should {
  //
  //    "render the index page" in {
  //      val home = route(app, FakeRequest(GET, "/")).get
  //
  //      status(home) mustBe Status.OK
  //      contentType(home) mustBe Some("text/html")
  //      contentAsString(home) must include ("Your new application is ready.")
  //    }
  //
  //  }
  //
  //  "CountController" should {
  //
  //    "return an increasing count" in {
  //      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "0"
  //      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "1"
  //      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "2"
  //    }
  //
  //  }
}
