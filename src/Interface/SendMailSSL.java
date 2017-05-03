/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
import javax.swing.JOptionPane;
class Mailer{  
    public static void send(String from,String password,String to,String sub,String msg){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           JOptionPane.showMessageDialog(null, "<html><strong>Bug report submitted Successfully.</strong><br/><p>Our support is doing their best to ensure that the problem is fixed.</p></html>","Techflay Error Reports",JOptionPane.INFORMATION_MESSAGE);
          } catch (MessagingException e) {
              //throw new RuntimeException(e);
             JOptionPane.showMessageDialog(null, "<html><strong>Oops! The bug Report was not submitted .</strong><br/><p>Please confirm that your internet connection is active and the password for the email is correct.</p><br/>"
                     + "Ensure your gmail account allows less secure apps to send email.</html>","Techflay Error Reports",JOptionPane.INFORMATION_MESSAGE);
          }    
             
    }  
}  
public class SendMailSSL{     
 public static void main(String[] args) {    
     new SendMailSSL();
 }    
}    