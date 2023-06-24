package enumeracoes_composicao.application;

import enumeracoes_composicao.entites.Comment;
import enumeracoes_composicao.entites.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgramPost {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comment comment1 = new Comment("Have a nice trip!");
        Comment comment2 = new Comment("Wow that's awesome!");
        Post post1 = new Post(dateFormat.parse("21/06/2023 11:40:35"),
                "Travelling to New Zealand",
                "I'm going to vistit this worderful country!",
                12);
        post1.addComment(comment1);
        post1.addComment(comment2);

        System.out.println(post1);

        Comment comment3 = new Comment("Good Nigth!");
        Comment comment4 = new Comment("May the force be with you.");
        Post post2 = new Post(dateFormat.parse("28/07/2023 12:02:17"),
                "Good nigth guys",
                "See you thomorrow",
                5);
        post2.addComment(comment3);
        post2.addComment(comment4);

        System.out.println(post2);
    }
}
