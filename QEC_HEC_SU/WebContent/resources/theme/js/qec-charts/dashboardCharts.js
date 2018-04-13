$(document).ready(function(){
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url = '/QEC_HEC_SU/dashboard/returnDashboardCharts';
	$.ajax({
		url :url,
		 type: "POST",
         contentType: "application/json",
		 async:false,
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) {
			employeeCommunityServicesByDepartment_fill_chart(data.returnEmployeeCommunityServicesByDepartmentInstituteCenter);
			hecXYResearchPapers_fill_chart(data.returnXYResearchPaperByDepartmentInstituteCenter);
			monthImpactFactorByHec_fill_chart(data.returnImpactFactorByHec);
			researchFundingGrants_fill_chart(data.returnResearchFundingByDepartmentInstituteCenter);
			travelGrants_fill_chart(data.returnTravelGrantsByDepartmentInstituteCenter);
		 }
	});
	

})


function employeeCommunityServicesByDepartment_fill_chart(data)
	{
		employeeServicesByDepartments = new Array();
		
		for (var i = 0; i < data.length; i++) {
			var employeeCommunityServiceData = data[i];
			employeeServices = new Array();
			employeeServices[0] = employeeCommunityServiceData.value1;
			employeeServices[1] = employeeCommunityServiceData.value8;
			employeeServicesByDepartments[i] = employeeServices;
		}
		
		$ ('#community_services').highcharts (
				  {
				        chart: {
				            type: 'column'
				        },
				        title: {
				            text: 'Community Services'
				        },
				        subtitle: {
				            text: ''
				        },
				        xAxis: {
				            type: 'category',
				            labels: {
				                rotation: -45,
				                style: {
				                    fontSize: '13px',
				                    fontFamily: 'Verdana, sans-serif'
				                }
				            }
				        },
				        yAxis: {
				            min: 0,
				            title: {
				                text: 'Employees'
				            }
				        },
				        legend: {
				            enabled: false
				        },
				        tooltip: {
				            pointFormat: ''
				        },
				        series: [{
				            name: 'Employees',
				            data: employeeServicesByDepartments,
				            dataLabels: {
				                enabled: true,
				                rotation: -90,
				                color: '#FFFFFF',
				                align: 'right',
				                format: '{point.y:.1f}', // one decimal
				                y: 10, // 10 pixels down from the top
				                style: {
				                    fontSize: '13px',
				                    fontFamily: 'Verdana, sans-serif'
				                }
				            }
				        }]
				    });
	}

function hecXYResearchPapers_fill_chart(data)
{
	departments = new Array();
	xResearchPapers = new Array();
	yResearchPapers = new Array();
	
	for (var i = 0; i < data.length; i++) {
		var xyResearchPaperData = data[i];
		departments[i] = xyResearchPaperData.value1;
		xResearchPapers[i] = xyResearchPaperData.value8;
		yResearchPapers[i] = xyResearchPaperData.value9;
	}
	
	console.log(departments);
	$('#journal_Hec_Category').highcharts ({
        chart: {
            type: 'column'
        },
        title: {
            text: 'HEC X Y research paper by department/institute/centre'
        },
        xAxis: {
            categories: departments
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Total'
            },
            stackLabels: {
                enabled: true,
                style: {
                    fontWeight: 'bold',
                    color: (Highcharts.theme&&Highcharts.theme.textColor)||'gray'
                }
            }
        },
        legend: {
            align: 'right',
            x: -30,
            verticalAlign: 'top',
            y: 25,
            floating: true,
            backgroundColor: (Highcharts.theme&&Highcharts.theme.background2)||'white',
            borderColor: '#CCC',
            borderWidth: 1,
            shadow: false
        },
        tooltip: {
            headerFormat: '<b>{point.x}</b><br/>',
            pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
        },
        plotOptions: {
            column: {
                stacking: 'normal',
                dataLabels: {
                    enabled: true,
                    color: (Highcharts.theme&&Highcharts.theme.dataLabelsColor)||'white',
                    style: {
                        textShadow: '0 0 3px black'
                    }
                }
            }
        },
        series: [{
                name: 'X',
                data: xResearchPapers
            }, {
                name: 'Y',
                data: yResearchPapers
            }]
	});
}

function monthImpactFactorByHec_fill_chart(data)
{
	hec = new Array();
	impactFactor = new Array();
	for (var i = 0; i < data.length; i++) 
	{
		var monthImpactFactorData = data[i];
		hec[i] = monthImpactFactorData[1];
		impactFactor[i] = monthImpactFactorData[2];
	}
	Highcharts.chart('impact_factor', {
	    chart: {
	        type: 'spline'
	    },
	    title: {
	        text: 'Monthly Impact Factor by HEC / Impact'
	    },
	    xAxis: {
	        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
	            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
		    },
	    yAxis: {
	        title: {
	            text: 'Ratio'
	        },
	        labels: {
	            formatter: function () {
	                return this.value;
	            }
	        }
	    },
	    tooltip: {
	        crosshairs: true,
	        shared: true
	    },
	    plotOptions: {
	        spline: {
	            marker: {
	                radius: 4,
	                lineColor: '#666666',
	                lineWidth: 1
	            }
	        }
	    },
	    series: [
	        {
		        name: 'Impact Factor',
			    marker: {
			    	symbol: 'circle'
			    },
			    data: hec
		    },
		    {
		        name: 'HEC',
		        marker: {
		            symbol: 'diamond'
		        },
		        data: impactFactor
		    }]
		});
	}

function researchFundingGrants_fill_chart(data)
{
	departments = new Array();
	hecGrants = new Array();
	interNationalGrants = new Array();
	nationalGrants = new Array();
	
	for (var i = 0; i < data.length; i++) {
		var researchFundingGrantsData = data[i];
		departments[i] = researchFundingGrantsData.value1;
		hecGrants[i] = researchFundingGrantsData.value8;
		nationalGrants[i] = researchFundingGrantsData.value9;
		interNationalGrants[i] = researchFundingGrantsData.value10;
	}
	
	$ ('#research_funding_grants').highcharts ({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Research Funding (Local/National/International)'
        },
        xAxis: {
            categories: departments
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Total'
            },
            stackLabels: {
                enabled: true,
                style: {
                    fontWeight: 'bold',
                    color: (Highcharts.theme&&Highcharts.theme.textColor)||'gray'
                }
            }
        },
        legend: {
            align: 'right',
            x: -30,
            verticalAlign: 'top',
            y: 25,
            floating: true,
            backgroundColor: (Highcharts.theme&&Highcharts.theme.background2)||'white',
            borderColor: '#CCC',
            borderWidth: 1,
            shadow: false
        },
        tooltip: {
            headerFormat: '<b>{point.x}</b><br/>',
            pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
        },
        plotOptions: {
            column: {
                stacking: 'normal',
                dataLabels: {
                    enabled: true,
                    color: (Highcharts.theme&&Highcharts.theme.dataLabelsColor)||'white',
                    style: {
                        textShadow: '0 0 3px black'
                    }
                }
            }
        },
        series: [{
                name: 'National',
                data: nationalGrants
            }, {
                name: 'International',
                data: interNationalGrants
            }, {
                name: 'HEC',
                data: hecGrants
            }]
    });
}

function travelGrants_fill_chart(data)
{
	departments = new Array();
	hecGrants = new Array();
	interNationalGrants = new Array();
	nationalGrants = new Array();
	
	for (var i = 0; i < data.length; i++) {
		var travelGrantsData = data[i];
		departments[i] = travelGrantsData.value1;
		hecGrants[i] = travelGrantsData.value8;
		nationalGrants[i] = travelGrantsData.value9;
		interNationalGrants[i] = travelGrantsData.value10;
	}
	
	$ ('#emp_travelgrands_new').highcharts ({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Travel Grants (Local/National/International)'
        },
        xAxis: {
            categories: departments
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Total'
            },
            stackLabels: {
                enabled: true,
                style: {
                    fontWeight: 'bold',
                    color: (Highcharts.theme&&Highcharts.theme.textColor)||'gray'
                }
            }
        },
        legend: {
            align: 'right',
            x: -30,
            verticalAlign: 'top',
            y: 25,
            floating: true,
            backgroundColor: (Highcharts.theme&&Highcharts.theme.background2)||'white',
            borderColor: '#CCC',
            borderWidth: 1,
            shadow: false
        },
        tooltip: {
            headerFormat: '<b>{point.x}</b><br/>',
            pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
        },
        plotOptions: {
            column: {
                stacking: 'normal',
                dataLabels: {
                    enabled: true,
                    color: (Highcharts.theme&&Highcharts.theme.dataLabelsColor)||'white',
                    style: {
                        textShadow: '0 0 3px black'
                    }
                }
            }
        },
        series: [{
                name: 'National',
                data: nationalGrants
            }, {
                name: 'International',
                data: interNationalGrants
            }, {
                name: 'HEC',
                data: hecGrants
            }]
    });
}
