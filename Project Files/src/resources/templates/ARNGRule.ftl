    -- Attribute Range Rule :: ${column} ${operand} ${minvalue} ${maxvalue}
    DECLARE
        l_passed boolean := false;
    BEGIN
        IF l_oper IN ('INS', 'UPD')
        THEN
            l_passed := :new.${column} ${operand} ${minvalue} AND ${maxvalue}
            
            IF NOT l_passed
            THEN 
                l_errors := l_errors || 'The value of ${column} violates -> ${column} ${operand} ${minvalue} - ${maxvalue}';
            END IF;
        END IF;
    END;