 -- Attribute List Rule :: ${column} <#list values as value>'${value}'<#if value_has_next>, </#if></#list>
    DECLARE
        l_passed boolean := false;
    BEGIN
        IF l_oper IN ('INS', 'UPD')
        THEN
            l_passed := :new.${column} in (<#list values as value>'${value}'<#if value_has_next>, </#if></#list>)
            
            IF NOT l_passed
            THEN 
                l_errors := l_errors || 'The value of ${column} must be one of: <#list values as value>${value}<#if value_has_next>, </#if></#list>';
            END IF;
        END IF;
    END;