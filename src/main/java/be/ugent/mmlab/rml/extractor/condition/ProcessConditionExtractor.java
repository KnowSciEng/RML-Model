/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.mmlab.rml.extractor.condition;

import be.ugent.mmlab.rml.model.TriplesMap;
import be.ugent.mmlab.rml.model.condition.ProcessCondition;
import be.ugent.mmlab.rml.model.std.StdProcessCondition;
import be.ugent.mmlab.rml.sesame.RMLSesameDataSet;
import be.ugent.mmlab.rml.vocabulary.RMLVocabulary;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;

/**
 *
 * @author andimou
 */
public class ProcessConditionExtractor extends ConditionExtractor {
    
    //Log
    private static final Logger log = LogManager.getLogger(ProcessConditionExtractor.class);
    
    public static Set<ProcessCondition> extractCondition(
            RMLSesameDataSet rmlMappingGraph, Resource object, TriplesMap triplesMap){
        log.debug(
                Thread.currentThread().getStackTrace()[1].getMethodName() + ": "
                + "Extract process conditions..");
        Set<ProcessCondition> result = new HashSet<ProcessCondition>();
        
        // Extract equal condition
        URI p = rmlMappingGraph.URIref(
                RMLVocabulary.CRML_NAMESPACE + RMLVocabulary.cRMLTerm.PROCESS_CONDITION);
        List<Statement> statements = rmlMappingGraph.tuplePattern(object, p, null);

        try {
            for (Statement statement : statements) {
                //assigns current equal condtion
                Resource ec = (Resource) statement.getObject();
                
                //retrieves condition
                p = rmlMappingGraph.URIref(
                        RMLVocabulary.CRML_NAMESPACE + RMLVocabulary.cRMLTerm.CONDITION);
                statements = rmlMappingGraph.tuplePattern(ec, p, null);
                String condition = statements.get(0).getObject().stringValue();         
                
                //retrieves value
                p = rmlMappingGraph.URIref(
                        RMLVocabulary.CRML_NAMESPACE + RMLVocabulary.cRMLTerm.VALUE);
                statements = rmlMappingGraph.tuplePattern(ec, p, null);
                String value = statements.get(0).getObject().stringValue();         

                if (value == null || condition == null) {
                    log.error(Thread.currentThread().getStackTrace()[1].getMethodName() + ": "
                            + object.stringValue()
                            + " must have exactly two properties condition and value. ");
                }
                try {
                    result.add(new StdProcessCondition(condition, value));
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(
                            ProcessConditionExtractor.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        } catch (ClassCastException e) {
            log.error(Thread.currentThread().getStackTrace()[1].getMethodName() + ": "
                    + "A resource was expected in object of predicateMap of "
                    + object.stringValue());
        } 
        log.debug("Extracting process condition done.");
        return result;
    }
    
}