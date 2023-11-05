package com.bimaapp.signup;

import java.io.Serializable;

public class RegisterCSS implements Serializable{
    
    private String style = "<style>" + 
    ".align {\n" + //
            "  -webkit-box-align: center;\n" + //
            "      -ms-flex-align: center;\n" + //
            "          align-items: center;\n" + //
            "  display: -webkit-box;\n" + //
            "  display: -ms-flexbox;\n" + //
            "  display: flex;\n" + //
            "  -webkit-box-orient: vertical;\n" + //
            "  -webkit-box-direction: normal;\n" + //
            "      -ms-flex-direction: column;\n" + //
            "          flex-direction: column;\n" + //
            "  -webkit-box-pack: center;\n" + //
            "      -ms-flex-pack: center;\n" + //
            "          justify-content: center;\n" + //
            "}\n" + //
            "\n" + //
            ".grid {\n" + //
            "  margin-left: auto;\n" + //
            "  margin-right: auto;\n" + //
            "  max-width: 320px;\n" + //
            "  max-width: 20rem;\n" + //
            "  width: 90%;\n" + //
            "}\n" + //
            "\n" + //
            ".hidden {\n" + //
            "  border: 0;\n" + //
            "  clip: rect(0 0 0 0);\n" + //
            "  height: 1px;\n" + //
            "  margin: -1px;\n" + //
            "  overflow: hidden;\n" + //
            "  padding: 0;\n" + //
            "  position: absolute;\n" + //
            "  width: 1px;\n" + //
            "}\n" + //
            "\n" + //
            ".icons {\n" + //
            "  display: none;\n" + //
            "}\n" + //
            "\n" + //
            ".icon {\n" + //
            "  display: inline-block;\n" + //
            "  fill: #606468;\n" + //
            "  font-size: 16px;\n" + //
            "  font-size: 1rem;\n" + //
            "  height: 1em;\n" + //
            "  vertical-align: middle;\n" + //
            "  width: 1em;\n" + //
            "}\n" + //
            "\n" + //
            "* {\n" + //
            "  -webkit-box-sizing: inherit;\n" + //
            "          box-sizing: inherit;\n" + //
            "}\n" + //
            "\n" + //
            "html {\n" + //
            "  -webkit-box-sizing: border-box;\n" + //
            "          box-sizing: border-box;\n" + //
            "  font-size: 100%;\n" + //
            "  height: 100%;\n" + //
            "}\n" + //
            "\n" + //
            "body {\n" + //
            "  background-color: #eee;\n" + //
            "  color: #000;\n" + //
            "  font-family: 'Open Sans', sans-serif;\n" + //
            "  font-size: 14px;\n" + //
            "  font-size: 0.875rem;\n" + //
            "  font-weight: 400;\n" + //
            "  height: 100%;\n" + //
            "  line-height: 1.5;\n" + //
            "  margin: 0;\n" + //
            "  min-height: 100vh;\n" + //
            "}\n" + //
            "\n" + //
            "a {\n" + //
            "  color: #000;\n" + //
            "  outline: 0;\n" + //
            "  text-decoration: none;\n" + //
            "}\n" + //
            "\n" + //
            "a:focus,\n" + //
            "a:hover {\n" + //
            "  text-decoration: underline;\n" + //
            "}\n" + //
            "\n" + //
            "input {\n" + //
            "  background-image: none;\n" + //
            "  border: 0;\n" + //
            "  color: inherit;\n" + //
            "  font: inherit;\n" + //
            "  margin: 0;\n" + //
            "  outline: 0;\n" + //
            "  padding: 0;\n" + //
            "  -webkit-transition: background-color 0.3s;\n" + //
            "  transition: background-color 0.3s;\n" + //
            "}\n" + //
            "\n" + //
            "input[type='submit'] {\n" + //
            "  cursor: pointer;\n" + //
            "}\n" + //
            "\n" + //
            ".form {\n" + //
            "  margin: -14px;\n" + //
            "  margin: -0.875rem;\n" + //
            "}\n" + //
            "\n" + //
            ".form input[type='password'],\n" + //
            ".form input[type='text'],\n" + //
            ".form input[type='submit'] {\n" + //
            "  width: 100%;\n" + //
            "}\n" + //
            "\n" + //
            ".form__field {\n" + //
            "  display: -webkit-box;\n" + //
            "  display: -ms-flexbox;\n" + //
            "  display: flex;\n" + //
            "  margin: 14px;\n" + //
            "  margin: 0.875rem;\n" + //
            "}\n" + //
            "\n" + //
            ".form__input {\n" + //
            "  -webkit-box-flex: 1;\n" + //
            "      -ms-flex: 1;\n" + //
            "          flex: 1;\n" + //
            "}\n" + //
            "\n" + //
            ".login {\n" + //
            "  color: #eee;\n" + //
            "}\n" + //
            "\n" + //
            ".login label,\n" + //
            ".login input[type='text'],\n" + //
            ".login input[type='password'],\n" + //
            ".login input[type='submit'] {\n" + //
            "  border-radius: 0.25rem;\n" + //
            "  padding: 16px;\n" + //
            "  padding: 1rem;\n" + //
            "}\n" + //
            "\n" + //
            ".login label {\n" + //
            "  background-color: #363b41;\n" + //
            "  border-bottom-right-radius: 0;\n" + //
            "  border-top-right-radius: 0;\n" + //
            "  padding-left: 20px;\n" + //
            "  padding-left: 1.25rem;\n" + //
            "  padding-right: 20px;\n" + //
            "  padding-right: 1.25rem;\n" + //
            "}\n" + //
            "\n" + //
            ".login input[type='password'],\n" + //
            ".login input[type='text'] {\n" + //
            "  background-color: #3b4148;\n" + //
            "  border-bottom-left-radius: 0;\n" + //
            "  border-top-left-radius: 0;\n" + //
            "}\n" + //
            "\n" + //
            ".login input[type='password']:focus,\n" + //
            ".login input[type='password']:hover,\n" + //
            ".login input[type='text']:focus,\n" + //
            ".login input[type='text']:hover {\n" + //
            "  background-color: #434a52;\n" + //
            "}\n" + //
            "\n" + //
            ".login input[type='submit'] {\n" + //
            "  background-color: #ea4c88;\n" + //
            "  color: #eee;\n" + //
            "  font-weight: 700;\n" + //
            "  text-transform: uppercase;\n" + //
            "}\n" + //
            "\n" + //
            ".login input[type='submit']:focus,\n" + //
            ".login input[type='submit']:hover {\n" + //
            "  background-color: #d44179;\n" + //
            "}\n" + //
            "\n" + //
            "p {\n" + //
            "  margin-bottom: 24px;\n" + //
            "  margin-bottom: 1.5rem;\n" + //
            "  margin-top: 24px;\n" + //
            "  margin-top: 1.5rem;\n" + //
            "}\n" + //
            "\n" + //
            ".text--center {\n" + //
            "  text-align: center;\n" + //
            "}"
    + "</style>";

    public String getStyle() {
        return style;
    }

}
