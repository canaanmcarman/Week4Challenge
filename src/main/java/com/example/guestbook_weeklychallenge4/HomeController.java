package com.example.guestbook_weeklychallenge4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
    public static long idSetter = 0;
    ArrayList<Entry> entries = new ArrayList<>();

    @RequestMapping("/")
    public String homepage() {
        return "homepage";
    }

    @GetMapping("/add")
    public String getFormPage(Model model) {
        Entry entry = new Entry();
        setId(entry);
        model.addAttribute("entry", entry);
        return "guestform";
    }
    @PostMapping("/add")
    public String getFromPage(@Valid Entry entry, BindingResult result) {
        if(result.hasErrors()) {
            return "guestform";
        } else {
            entries.add(entry);
            return "confirm";
        }
    }
    @RequestMapping("/viewAll")
    public String viewAllEntries(Model model) {
        model.addAttribute("entries", entries);
        return "viewallentries";
    }
    public void setId(Entry entry) {
        idSetter += 1;
        entry.setId(idSetter);
    }
}
