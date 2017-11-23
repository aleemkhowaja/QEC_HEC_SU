/**
 * remove child elements of html
 */

function remove_child_Elements(id) 
{
    var elem = document.getElementById(id);
    if(elem != null)
    {
    	elem.parentNode.removeChild(elem);
        return false;
    }
}