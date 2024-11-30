package com.cosconcosplay.coscon.model;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
@Entity
@Data
@Builder
@Table(name = "resposta")
public class Reply {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "comentario_id")
    private Comment comentario;
    @ManyToOne
    @JoinColumn(name = "primaryReply_id")
    private Reply primaryReply;
    private String resposta;
    @OneToMany(mappedBy =  "primaryReply", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> children;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Cliente cliente;
    
    
}
