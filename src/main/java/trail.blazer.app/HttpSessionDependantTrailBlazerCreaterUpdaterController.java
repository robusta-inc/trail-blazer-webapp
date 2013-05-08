package trail.blazer.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/trailBlaze/non/annotated")
public class HttpSessionDependantTrailBlazerCreaterUpdaterController {
    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdateTrailBlazer(@RequestParam("addTrail") String toAddTo, HttpSession session) {
        trailBlazerFrom(session).addThis(toAddTo);
        return "trail.blazer.renderer";
    }

    private TrailBlazer trailBlazerFrom(HttpSession session) {
        TrailBlazer trailBlazer;
        if(session.getAttribute("theTrail") == null) {
            trailBlazer = new TrailBlazer();
            session.setAttribute("theTrail", trailBlazer);
        } else {
            trailBlazer = (TrailBlazer) session.getAttribute("theTrail");
        }
        return trailBlazer;
    }

    @RequestMapping(value = "reset", method = RequestMethod.POST)
    public String createOrUpdateTrailBlazer(HttpSession session) {
        session.setAttribute("theTrail", new TrailBlazer());
        return "trail.blazer.renderer";
    }
}
