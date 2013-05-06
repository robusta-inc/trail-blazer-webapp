package trail.blazer.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trailBlaze")
public class TrailBlazerCreaterUpdaterController {
    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdateTrailBlazer(@RequestParam("addTrail") String toAddTo, @SessionAttribute(value = "theTrail", createIfMissing = true) TrailBlazer trailBlazer) {
        trailBlazer.addThis(toAddTo);
        return "trail.blazer.renderer";
    }

    @RequestMapping(value = "reset", method = RequestMethod.POST)
    public String createOrUpdateTrailBlazer(@SessionAttribute(value = "theTrail", createNew = true) TrailBlazer trailBlazer) {
        return "trail.blazer.renderer";
    }
}
