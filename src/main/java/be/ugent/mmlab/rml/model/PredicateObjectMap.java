package be.ugent.mmlab.rml.model;

import be.ugent.mmlab.rml.model.RDFTerm.*;

import java.util.Set;

/**
 * *************************************************************************
 *
 * RML - Model : PredicateObjectMap Interface
 *
 *
 * @author andimou
 *
 ***************************************************************************
 */
public interface PredicateObjectMap {

    /**
     * A Predicate-Object Map is represented by a resource that references one
     * or more Predicate Maps.
     */
    public Set<PredicateMap> getPredicateMaps();

    /**
     *
     * @param predicateMaps
     */
    public void setPredicateMaps(Set<PredicateMap> predicateMaps);

    /**
     * A Predicate-Object Map is represented by a resource that references one
     * or more Object Map or Referencing Object Map. 
     */
    public Set<ObjectMap> getObjectMaps();

    /**
     *
     * @param objectMaps
     */
    public void setObjectMaps(Set<ObjectMap> objectMaps);

    /**
     * A Predicate-Object Map is represented by a resource that references
     * exactly one Object Map or one Referencing Object Map. 
     */
    public Set<ReferencingObjectMap> getReferencingObjectMaps();

    /**
     *
     * @param referencingOjectMap
     */
    public void setReferencingObjectMap(Set<ReferencingObjectMap> referencingOjectMap);

    public Set<FunctionTermMap> getFunctionTermMaps();

    public void setFunctionTermMap(Set<FunctionTermMap> functionTermMaps);

    /**
     * Indicates if a PredicateObjectMap is associated with ReferencingObjectMap. 
     */
    public boolean hasReferencingObjectMaps();

    /**
     * A Predicate Object Map knows in own Triples Map container.
     */
    public TriplesMap getOwnTriplesMap();

    /**
     *
     * @param ownTriplesMap
     */
    public void setOwnTriplesMap(TriplesMap ownTriplesMap);

    /**
     * Any Predicate-Object Map may have one or more associated Graph Maps.
     */
    public Set<GraphMap> getGraphMaps();

    /**
     *
     * @param graphmaps
     */
    public void setGraphMaps(Set<GraphMap> graphmaps);

    /**
     * Get dcterms:type from predicate object map
     */
    public String getDCTermsType();

    /**
     * Set dcterms:type in a predicate object map
     * @param dcTermsType
     */
    public void setDCTermsType(String dcTermsType);

}
