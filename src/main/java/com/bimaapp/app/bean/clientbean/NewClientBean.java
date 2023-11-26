package com.bimaapp.app.bean.clientbean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.bimaapp.app.bean.GenericBean;
import com.bimaapp.app.model.Client;
@Stateless
@Remote
public class NewClientBean extends GenericBean<Client> implements NewClientBeanI{
    
   
}
