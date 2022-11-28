package com.SpringWebOne.spring5webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String publisherOwner;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> publisherName=new HashSet<>();
    private String state;

    public Publisher() {
    }

    public Publisher(String publisherOwner, String state) {
        this.publisherOwner=publisherOwner;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherOwner() {
        return publisherOwner;
    }

    public void setPublisherOwner(String publisherOwner) {
        this.publisherOwner = publisherOwner;
    }

    public Set<Book> getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(Set<Book> publisherName) {
        this.publisherName = publisherName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherOwner='" + publisherOwner + '\'' +
                ", publisherName=" + publisherName +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


}
