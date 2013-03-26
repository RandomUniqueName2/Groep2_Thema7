    -- Attribute Compare Rule :: ${column} ${operand} ${value}
    DECLARE
        l_passed boolean := true;
    BEGIN
        IF l_oper IN ('INS', 'UPD')
        THEN
            l_passed := :new.${column} ${operand} ${value}
            
            IF NOT l_passed
            THEN 
                l_errors := l_errors || 'The value of ${column} violates -> ${column} ${operand} ${value}';
            END IF;
        END IF;
    END;