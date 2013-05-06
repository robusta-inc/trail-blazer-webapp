trail-blazer-webapp
===================

A test web app that persists the user trail in a trail blazer and displays a breadcrumb

Spring MVC, trail brazer state on Http Session, session handling is annotation driven - @SessionAttribute

<pre>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>annotated-session-attribute</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
</pre> from https://repository-robusta.forge.cloudbees.com/snapshot/ (public repository)

In the application context
```xml
    <mvc:annotation-driven>
        <mvc:argument-resolvers>
            <bean class="org.springframework.web.method.support.SessionAttributeHandlerMethodArgumentResolver"/>
        </mvc:argument-resolvers>
    </mvc:annotation-driven>
```

And in the controllers 
```java
@Controller
@RequestMapping("/trailBlaze")
public class TrailBlazerCreaterUpdaterController {
    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdateTrailBlazer(@RequestParam("addTrail") String toAddTo, 
      @SessionAttribute(value = "theTrail", createIfMissing = true) TrailBlazer trailBlazer) {
        trailBlazer.addThis(toAddTo);
        return "trail.blazer.renderer";
    }

    @RequestMapping(value = "reset", method = RequestMethod.POST)
    public String createOrUpdateTrailBlazer(@SessionAttribute(value = "theTrail", createNew = true) 
      TrailBlazer trailBlazer) {
        return "trail.blazer.renderer";
    }
}
```

A sample app is here: http://trail-blazer-app.robusta.cloudbees.net/

<img style="width: 178px; height: 61px;" src="https://www.cloudbees.com/sites/default/files/Button-Built-on-CB-1.png" alt="">
<img style="width: 178px; height: 61px;" src="https://www.cloudbees.com/sites/default/files/Button-Powered-by-CB.png" alt="">

