package com.hekpdesk.entity;

import com.hekpdesk.utils.Priority;
import com.hekpdesk.utils.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "help_desk_tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String summary;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(updatable = false)
    private String username;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;
    @Enumerated(EnumType.STRING)
    private Status status;


    @PrePersist
    public void preSave()
    {
        if(this.createdOn==null)
        {
            this.createdOn=LocalDateTime.now();
        }
        this.updatedOn=LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate()
    {
        this.updatedOn=LocalDateTime.now();
    }

}
