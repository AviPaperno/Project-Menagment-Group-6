package viktor.paperno.demo.controller;


import viktor.paperno.demo.dao.MarkJdbc;
import viktor.paperno.demo.model.Mark_;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MarkController {

    private final MarkJdbc markJdbc;

    public MarkController(MarkJdbc markJdbc)
    {
        this.markJdbc = markJdbc;
    }

    @GetMapping("/mark/{id}")
    public Mark_ getMark(@PathVariable int id)
    {
        Mark_ mark = markJdbc.get(id);
        System.out.println(mark);
        return mark;
    }
}
