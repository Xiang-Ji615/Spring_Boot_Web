package jj.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="Web")
public class WebController {

	@RequestMapping(value="Index/{jasper}", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String index(@PathVariable(name="jasper") Optional<String> jasper, @MatrixVariable int q, ModelMap map){
		jasper.orElse("Empty JJ Value");
		System.out.println(q);
		map.addAttribute("jj", jasper.get());
		map.addAttribute("q", q);
		return "Index";
	}
	
	@ModelAttribute
	public void addTime(ModelMap map) {
		map.addAttribute("time", new Date());
	}
	
}
