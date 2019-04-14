
package com.example.WhatTheTekBlog.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long postID;


  @NotNull
  @Size(max = 100)
  @Column(nullable = false)
  private String postTitle;

  @NotNull
  @Size(max = 250)
  @Column(nullable = false)
  @Type(type = "text")
  private String postSummary;

  @NotNull
  @Lob
  @Column(nullable = false)
  private String postContent;

  @NotNull
  private Date createdDate = new Date();

  @Transient
  Calendar calendar = Calendar.getInstance();

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
  private Set<Comments> comments = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "listOfPosts")
  private Set<Tags> tagsSet = new HashSet<>();

  @ManyToOne(cascade = CascadeType.ALL)
  private AppUser creator;

  public Post(@NotNull @Size(max = 100) String postTitle, @NotNull @Size(max = 250) String postDescription, @NotNull String postContent,
             List<Comments> comments, List<Tags> tagsList, AppUser author) {
    this.postTitle = postTitle;
    this.postSummary = postDescription;
    this.postContent = postContent;
    this.createdDate = calendar.getTime();
   // this.comments = comments;
   // this.tagsList = tagsList;
    //this.creater = author;
  }

  public Post() {
  }

  public Long getPostID() {
    return postID;
  }

  public void setPostID(Long postID) {
    this.postID = postID;
  }

  public String getPostTitle() {
    return postTitle;
  }

  public void setPostTitle(String postTitle) {
    this.postTitle = postTitle;
  }

  public String getPostSummary() {
    return postSummary;
  }

  public void setPostSummary(String postSummary) {
    this.postSummary = postSummary;
  }

  public String getPostContent() {
    return postContent;
  }

  public void setPostContent(String postContent) {
    this.postContent = postContent;
  }

  public Calendar getCalendar() {
    return calendar;
  }

  public void setCalendar(Calendar calendar) {
    this.calendar = calendar;
  }

  public Set<Comments> getComments() {
    return comments;
  }

  public void setComments(Set<Comments> comments) {
    this.comments = comments;
  }

  public Set<Tags> getTagsSet() {
    return tagsSet;
  }

  public void setTagsSet(Set<Tags> tagsSet) {
    this.tagsSet = tagsSet;
  }

  public AppUser getCreator() {
    return creator;
  }

  public void setCreator(AppUser creator) {
    this.creator = creator;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }




}
