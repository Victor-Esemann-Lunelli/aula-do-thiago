package model;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-07T11:34:04", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(cliente.class)
public class cliente_ { 

    public static volatile SingularAttribute<cliente, String> telefone;
    public static volatile SingularAttribute<cliente, String> cpf;
    public static volatile SingularAttribute<cliente, String> nome;
    public static volatile SingularAttribute<cliente, Integer> id;
    public static volatile SingularAttribute<cliente, Date> dataNascimento;

}