package sweter2_web_jpa_sec.sweter2_web_jpa_sec;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sweter2_web_jpa_sec.sweter2_web_jpa_sec.domain.Message;
import sweter2_web_jpa_sec.sweter2_web_jpa_sec.repos.MessageRepos;


import javax.validation.Valid;

import java.util.Map;

//http://localhost:8080/greeting?name=vvvv

@Controller
public class GreetingController {
    @Autowired
    private MessageRepos messageRepos;

    @GetMapping("/greeting")
    public String greeting
            (@RequestParam(name = "name", required = false, defaultValue = "World")
                     String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/main2")
    public String main2(Map<String, Object> model) {
        model.put("some", "hello lets_code!!!!");
        return "main2";
    }

    @RequestMapping(name = "", method = RequestMethod.GET)
    public String main(Map<String, Object> model) {

        Iterable<Message> messages = messageRepos.findAll();
        model.put("messages", messages);
        return "main";
    }

    // контролер для формы

    @PostMapping
    public String add(@Valid    Message mes,
                      BindingResult bindingResult,
            @RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        // создаем  по полученным данным обект  месадж


        if(bindingResult.hasErrors()) {
            Message mess = new Message("Ошибка заполнения", "Ошибка");
           messageRepos.save(mess);

            return  "redirect:main";
        }
        Message message = new Message(text, tag);
        // сохраняем  ево в бд
        messageRepos.save(message);
        // тут  мы  берм  данный из репозитория
        Iterable<Message> messages = messageRepos.findAll();
        // ложим их в  модель и отдаем  пользователю
        model.put("messages", messages);

        return "main";
    }

@PostMapping("filter")
public String filter(@RequestParam String filter, Map<String, Object> model) {

       // поскольку  лист имплементирует интреабле можем поставить вместо листа интерабле
    Iterable<Message> messages;

    if (filter != null && !filter.isEmpty()) {
        // возращет лист но меняем его на интерабле
        messages = messageRepos.findByTag(filter);
    } else {
        // финд ал возвращет  интреабле
        messages = messageRepos.findAll();
    }

    model.put("messages", messages);

    return "main";
}
}


