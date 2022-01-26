package com.devsuperior.dslearnbds.resources;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationResource {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> notificationsForCurrentUser(
            @RequestParam(name = "unreadOnly", defaultValue = "false") Boolean unreadOnly,
            Pageable pageable) {
        Page<NotificationDTO> page = notificationService.notificationsForCurrentUser(unreadOnly, pageable);
        return ResponseEntity.ok().body(page);
    }
}
