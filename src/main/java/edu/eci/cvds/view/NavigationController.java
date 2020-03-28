/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Jairo Gomez
 */
@ManagedBean(name = "NavigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {
   //this managed property will read value from request parameter pageId
  
   @ManagedProperty(value = "#{param.pageId}")
   private String pageId;

   //condional navigation based on pageId
   //if pageId is 1 show page1.xhtml,
   //if pageId is 2 show page2.xhtml
   //else show home.xhtml

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
   
   
   
   public String showPage() {
      if(pageId == null) {
         return "index";
      }
      System.out.println(pageId);
      switch (pageId) {
           case "1":
               return "RegistroCliente";
           case "2":
               return "RegistroAlquiler";
           case "3":
               return "index";
           default:
               return "index";
       }
   }
}