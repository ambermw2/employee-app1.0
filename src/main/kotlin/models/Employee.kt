package ie.setu.models

import ie.setu.roundTwoDecimals

class Employee (var firstName: String, var surname : String, var gender : Char,
                var employeeID : Int, var grossSalary : Double, var payePercentage : Double,
                var prsiPercentage : Double, var annualBonus : Double,
                var cycleToWorkMonthlyDeduction : Double, ){


    fun getFullName() = when (gender){
        'm', 'M' -> "Mr. ${firstName} ${surname}"
        'f', 'F' -> "Ms.  ${firstName} ${surname}"
        else ->  "${firstName} ${surname}"
    }

    fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)
    fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (prsiPercentage / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage / 100))
    fun getMonthlyBonus() = roundTwoDecimals((annualBonus / 12))
    fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonus / 12))
    fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkMonthlyDeduction))
    fun getNetMonthlyPay() = roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions())

    fun getPayslip() = """                       
    |_______________________________________________________________________                                                                 
    |     Monthly Payslip:             ${getFullName()}, ID: ${employeeID}                                                                                 
    |_______________________________________________________________________                                                                 
    |     PAYMENT DETAILS (gross pay: ${getGrossMonthlyPay()})     
    |          Salary: ${getMonthlySalary()}
    |          Bonus:  ${getMonthlyBonus()}
    |_______________________________________________________________________
    |     DEDUCTION DETAILS (total Deductions: ${getTotalMonthlyDeductions()})    
    |          PAYE: ${getMonthlyPAYE()}
    |          PRSI: ${getMonthlyPRSI()}
    |          Cycle To Work: ${cycleToWorkMonthlyDeduction}
    |_______________________________________________________________________
    |    NET PAY:${getNetMonthlyPay()}
    |_______________________________________________________________________""".trimMargin("|")

    override fun toString(): String {
        return "Employee(annualBonus=$annualBonus, firstName='$firstName', surname='$surname', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, cycleToWorkMonthlyDeduction=$cycleToWorkMonthlyDeduction)"
    }


}