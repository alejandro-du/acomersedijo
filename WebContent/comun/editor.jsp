<%-- 
    Author     : Alejandro
    Description: Incluye scripts necesarios para mostrar el editor avanzado de texto.
--%>

<%@ include file="/comun/include.jsp" %>

<s:url id="urlPathFckeditor" value="/scripts/fckeditor/" includeParams="false" />
<s:url id="urlFckEditor" value="/scripts/fckeditor/fckeditor.js" includeParams="false"  />

<script src="${urlFckEditor}"></script>

<script type="text/javascript">
    
    function editor(textareaId) {

        var oFCKeditor = new FCKeditor(textareaId);
        
        oFCKeditor.BasePath	= '<c:out value="${urlPathFckeditor}" />';
        oFCKeditor.Height	= 500;
        oFCKeditor.Value	= '';
        
        oFCKeditor.ReplaceTextarea();
    }
    
</script>
