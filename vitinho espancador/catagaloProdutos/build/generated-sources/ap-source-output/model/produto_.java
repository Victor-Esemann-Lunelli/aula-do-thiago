package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.categoria;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-29T17:15:06", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(produto.class)
public class produto_ { 

    public static volatile SingularAttribute<produto, Integer> idprodutos;
    public static volatile SingularAttribute<produto, categoria> categoria;
    public static volatile SingularAttribute<produto, Double> valor;
    public static volatile SingularAttribute<produto, String> descricao;

}