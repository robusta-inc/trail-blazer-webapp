<%@ page import="trail.blazer.app.TrailBlazer" %>
<div>

    <% TrailBlazer theTrail = (TrailBlazer) session.getAttribute("theTrail");
        if(!theTrail.isEmpty()) {  %>
            <b>The Trail so far</b>
        <% }
        for (java.lang.String aTrail  : theTrail) { %>
        <%= aTrail %> =>
    <% } %>
</div>