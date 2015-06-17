package be.ugent.mmlab.rml.model;

import be.ugent.mmlab.rml.condition.model.BindCondition;
import be.ugent.mmlab.rml.condition.model.Condition;
import be.ugent.mmlab.rml.condition.model.BooleanCondition;
import be.ugent.mmlab.rml.condition.model.ProcessCondition;
import be.ugent.mmlab.rml.condition.model.SplitCondition;
import be.ugent.mmlab.rml.input.model.InputSource;
import be.ugent.mmlab.rml.vocabulary.QLVocabulary;
import java.util.Set;

/**
 * RML Model
 *
 * @author mielvandersande, andimou
 */
public interface LogicalSource {

    /**
     * Every logical source has an expression resulting in a list of iterating
     * values.
     */
    public String getReference();

    /**
     * Every logical source has an identifier, which is a schema-qualified name
     * pointing at a source.
     */
    public String getSource();
    
    /**
     *
     * @return
     */
    public InputSource getInputSource();

    /**
     * Every logical source can indicate how its expression should be
     * interpreted
     */
    public QLVocabulary.QLTerm getReferenceFormulation();
    
    //TODO:take the following separately
    
    /**
     *
     * @return
     */
    public String getSplitCondition();
    
    /**
     *
     * @return
     */
    public Set<BooleanCondition> getEqualConditions();
        
    /**
     *
     * @return
     */
    public Set<ProcessCondition> getProcessConditions();
        
    /**
     *
     * @return
     */
    public Set<SplitCondition> getSplitConditions();
        
    /**
     *
     * @return
     */
    public Set<BindCondition> getBindConditions();
    
    /**
     *
     * @return
     */
    public Set<Condition> getConditions();
}
