<%-- 
    Author     : Alejandro
    Description: Incluye scripts necesarios para mostrar calendarios.
--%>

<%@ include file="/comun/include.jsp" %>

<s:url id="urlCalendar1" value="/scripts/calendar/calendar.js" includeParams="false"  />
<s:url id="urlCalendar2" value="/scripts/calendar/lang/calendar-es.js" includeParams="false"  />
<s:url id="urlCalendar3" value="/scripts/calendar/calendar-setup.js" includeParams="false"  />

<script src="${urlCalendar1}"></script>
<script src="${urlCalendar2}"></script>
<script src="${urlCalendar3}"></script>

<script type="text/javascript">
    
	function calendar(idInput, idButton, time) {
	    Calendar.setup({
	        inputField:   idInput,    // id of the input field
	        ifFormat:     time ? "%Y-%m-%d %H:%M" : "%Y-%m-%d", // format of the input field
	        button:       idButton,   // trigger for the calendar (button ID)
	        step:         1,          // show all years in drop-down boxes (instead of every other year as default)
	        showsTime:    time,
	        firstDay:     0
	    });
	}
    
</script>
