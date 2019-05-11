<%@ include file="/WEB-INF/jsp/init.jsp"%>

<p>
	<b><liferay-ui:message key="mkdevspring.caption" /></b> Hello World
	Spring MVC Portlet ${saveChangesActionURL}



	<button onClick="ajaxGet()">Ajax Test</button>
</p>
<script type="text/javascript">
		function ajaxGet() {
			var url = [[${sampleResourceURL}]];
			var r = new XMLHttpRequest();
			r.open("GET", url, true);
			r.onreadystatechange = function() {
				if(this.status == 200 && this.readyState == XMLHttpRequest.DONE) {
					alert("AJAX Response = "+r.responseText);
				}
			};
			r.send();
		}
	</script>

