package nz.zoltan.springmongo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @GetMapping("")
    fun showLiveMessage() = "It's live."
}
