package com.exercice.student.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table
public class Student implements Serializable{
    @Id
    @Column(nullable = false, length = 8)
    private String id_student;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private Boolean status;
}