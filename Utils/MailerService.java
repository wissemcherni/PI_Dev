package production.x_change.Utils;

public class MailerService {
    public void replyMail(String mail ,String Username , String Description,String title) {
        String from = "zaher.amri@esprit.tn";
        String pass = "not today";
        String[] to = {"" + mail}; // list of recipient email addresses
        String subject = ""+title;
        String body = "Greetings "+Username+", \n x-Change wanted to contact you as this : \n"+Description;
        MailService.sendFromGMail(from,pass,to,subject,body);
    }
}
