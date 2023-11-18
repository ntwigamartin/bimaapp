package com.bimaapp.utils;

import java.io.Serializable;
import java.lang.reflect.Field;

public class RenderHtmlForm implements Serializable{
    
    public static String renderForm(Class<?> model) {

        String htmlForm = "";
        Field [] fields = model.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(HtmlFormField.class) ) {
                continue;
            }
      
            HtmlFormField formField = field.getAnnotation(HtmlFormField.class);

            String fieldName = field.getName();

            
            htmlForm += "<label for=\"" + fieldName + "\">" + formField.label() + ":</label><br>";
            htmlForm += "<input type=\"" +formField.inputType()+ "\" id=\"" + fieldName + "\" name=\"" + fieldName 
            + "\"class=\"form_input\"" + "required>";
            
            
        }

        htmlForm += "<input type=\"submit\" value=\"Submit\">";
        // htmlForm += "</form><br/>";

        return htmlForm;
    }
}
