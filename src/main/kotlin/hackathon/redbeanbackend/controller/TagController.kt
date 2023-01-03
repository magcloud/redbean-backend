package hackathon.redbeanbackend.controller

import hackathon.redbeanbackend.dto.request.TagCreateDTO
import hackathon.redbeanbackend.dto.response.TagResponseDTO
import hackathon.redbeanbackend.service.TagService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/tag")
class TagController(private val tagService: TagService) {
    @GetMapping("/{id}")
    fun onRegisterRequested(@PathVariable id: Long): ResponseEntity<TagResponseDTO> {
        val result = tagService.findTagById(id)
        return ResponseEntity.ok(result)
    }

    @PostMapping
    fun createNewTag(@RequestBody @Valid dto: TagCreateDTO): ResponseEntity<TagResponseDTO> {
        val result = tagService.createNewTag(dto)
        return ResponseEntity.ok(result)
    }
}
