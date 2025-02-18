package com.example.portfolio.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "portfolio")
public class PortfolioEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Long id;

@Column(name = "name")
private String name;

@Column(name ="title")
private String title;

@Column(name = "content")
private String content;

@Column(name = "created_at")
private Timestamp createdAt;

@Column(name = "updated_at")
private Timestamp updatedAt;
}
