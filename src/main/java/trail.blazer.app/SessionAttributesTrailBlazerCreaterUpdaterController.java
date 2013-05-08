package trail.blazer.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trailBlaze/session/attributes")
@SessionAttributes("theTrail")
public class SessionAttributesTrailBlazerCreaterUpdaterController {
    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdateTrailBlazer(@RequestParam("addTrail") String toAddTo, ModelMap modelMap) {
        trailBlazer(modelMap).addThis(toAddTo);
        return "trail.blazer.renderer";
    }

    private TrailBlazer trailBlazer(ModelMap modelMap) {
        if(modelMap.containsKey("theTrail")) {
            return (TrailBlazer) modelMap.get("theTrail");
        } else {
            TrailBlazer value = new TrailBlazer();
            modelMap.put("theTrail", value);
            return value;
        }
    }

    @RequestMapping(value = "reset", method = RequestMethod.POST)
    public String createOrUpdateTrailBlazer(@ModelAttribute("theTrail") TrailBlazer trailBlazer) {
        trailBlazer.empty();
        return "trail.blazer.renderer";
    }
}
