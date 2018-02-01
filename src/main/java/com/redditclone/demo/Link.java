package com.redditclone.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=5)
    private String title;

    @NotNull
    @Size(min=5)
    private String url;

    @NotNull
    @Size(min=5)
    private String date;

    @NotNull
    @Size(min=2)
    private String submittedBy;


}
