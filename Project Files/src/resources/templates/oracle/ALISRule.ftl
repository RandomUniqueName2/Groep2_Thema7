    -- Attribute List Rule :: ${column} ${valuelist}
    DECLARE
        l_passed boolean := false;
    BEGIN
        IF l_oper IN ('INS', 'UPD')
        THEN
            l_passed := :new.${column} in(${valuelist})
            
            IF NOT l_passed
            THEN 
                l_errors := l_errors || 'The value of ${column} violates -> ${column} ${operand} ${value}';
            END IF;
        END IF;
    END;