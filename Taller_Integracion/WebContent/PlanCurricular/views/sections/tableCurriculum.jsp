<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% System.out.println("tableCurriculum"); %>
<table id="tb-curriculum-required" class="table-curriculum">
	<thead>
		<tr>
			<th rowspan="2">Codigo</th>
			<th rowspan="2">Curso</th>
			<th rowspan="2">Creditos</th>
			<th colspan="3">Horas</th>
			<th rowspan="2">Requisitos</th>	
		</tr>
		<tr>
			<th>Teoria</th>
			<th>Practica</th>
			<th>Laboratorio</th>	
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan="7" class="subtitle"> I </td>
		</tr>
		<c:set var="t01" value="0"></c:set>
		<c:forEach items="${requiredCourses}" var="course">
			<c:if test="${course.cycle == 1}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<c:set var="t01" value="${t01 + course.credits}"/>
			</c:if>
		</c:forEach>
		<tr>
			<td colspan="2">&nbsp;</td>
			<td>${t01}</td>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="7" class="subtitle"> II </td>
		</tr>
		<c:set var="t02" value="0"></c:set>
		<c:forEach items="${requiredCourses}" var="course">
			<c:if test="${course.cycle == 2}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<c:set var="t02" value="${t02 + course.credits}"/>
			</c:if>
		</c:forEach>
		<tr>
			<td colspan="2">&nbsp;</td>
			<td>${t02}</td>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="7" class="subtitle"> III </td>
		</tr>
		<c:set var="t03" value="0"></c:set>
		<c:forEach items="${requiredCourses}" var="course">
			<c:if test="${course.cycle == 3}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<c:set var="t03" value="${t03 + course.credits}"/>
			</c:if>
		</c:forEach>
		<tr>
			<td colspan="2">&nbsp;</td>
			<td>${t03}</td>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="7" class="subtitle"> IV </td>
		</tr>
		<c:set var="t04" value="0"></c:set>
		<c:forEach items="${requiredCourses}" var="course">
			<c:if test="${course.cycle == 4}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<c:set var="t04" value="${t04 + course.credits}"/>
			</c:if>
		</c:forEach>
		<tr>
			<td colspan="2">&nbsp;</td>
			<td>${t04}</td>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="7" class="subtitle"> V </td>
		</tr>
		<c:set var="t05" value="0"></c:set>
		<c:forEach items="${requiredCourses}" var="course">
			<c:if test="${course.cycle == 5}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<c:set var="t05" value="${t05 + course.credits}"/>
			</c:if>
		</c:forEach>
		<tr>
			<td colspan="2">&nbsp;</td>
			<td>${t05}</td>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="7" class="subtitle"> VI </td>
		</tr>
		<c:set var="t06" value="0"></c:set>
		<c:forEach items="${requiredCourses}" var="course">
			<c:if test="${course.cycle == 6}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<c:set var="t06" value="${t06 + course.credits}"/>
			</c:if>
		</c:forEach>
		<tr>
			<td colspan="2">&nbsp;</td>
			<td>${t06}</td>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="7" class="subtitle"> VII </td>
		</tr>
		<c:set var="t07" value="0"></c:set>
		<c:forEach items="${requiredCourses}" var="course">
			<c:if test="${course.cycle == 7}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<c:set var="t07" value="${t07 + course.credits}"/>
			</c:if>
		</c:forEach>
		<tr>
			<td colspan="2">&nbsp;</td>
			<td>${t07}</td>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="7" class="subtitle"> VIII </td>
		</tr>
		<c:set var="t08" value="0"></c:set>
		<c:forEach items="${requiredCourses}" var="course">
			<c:if test="${course.cycle == 8}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<c:set var="t08" value="${t08 + course.credits}"/>
			</c:if>
		</c:forEach>
		<tr>
			<td colspan="2">&nbsp;</td>
			<td>${t08}</td>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="7" class="subtitle"> IX </td>
		</tr>
		<c:set var="t09" value="0"></c:set>
		<c:forEach items="${requiredCourses}" var="course">
			<c:if test="${course.cycle == 9}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<c:set var="t09" value="${t09 + course.credits}"/>
			</c:if>
		</c:forEach>
		<tr>
			<td colspan="2">&nbsp;</td>
			<td>${t09}</td>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="7" class="subtitle"> X </td>
		</tr>
		<c:set var="t10" value="0"></c:set>
		<c:forEach items="${requiredCourses}" var="course">
			<c:if test="${course.cycle == 10}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<c:set var="t10" value="${t10 + course.credits}"/>
			</c:if>
		</c:forEach>
		<tr>
			<td colspan="2">&nbsp;</td>
			<td>${t10}</td>
			<td colspan="4">&nbsp;</td>
		</tr>
	</tbody>
</table>
<br/>
<table id="tb-curriculum-mention" class="table-curriculum">
	<thead>
		<tr>
			<th colspan="7"> CURSOS ELECTIVOS DE MENCION </th>
		</tr>
		<tr>
			<th rowspan="2">Codigo</th>
			<th rowspan="2">Curso</th>
			<th rowspan="2">Creditos</th>
			<th colspan="3">Horas</th>
			<th rowspan="2">Requisitos</th>	
		</tr>
		<tr>
			<th>Teoria</th>
			<th>Practica</th>
			<th>Laboratorio</th>	
		</tr>
	</thead>
	<tbody>
		<tr>
			<th colspan="7"> MENCION EN SISTEMAS DE INFORMACION </th>
		</tr>
		<c:forEach items="${mentionCourses}" var="course">
			<c:set var="contains" value="false" />
			<c:forEach items="${course.mentions}" var="item">
			  <c:if test="${item eq 1}">
			    <c:set var="contains" value="true" />
			  </c:if>
			</c:forEach>
			<c:if test="${contains eq 'true'}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:if>
		</c:forEach>
		<tr>
			<th colspan="7"> MENCION EN TECNOLOGIAS DE INFORMACION </th>
		</tr>
		<c:forEach items="${mentionCourses}" var="course">
			<c:set var="contains" value="false" />
			<c:forEach items="${course.mentions}" var="item">
			  <c:if test="${item eq 2}">
			    <c:set var="contains" value="true" />
			  </c:if>
			</c:forEach>
			<c:if test="${contains eq 'true'}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:if>
		</c:forEach>
		<tr>
			<th colspan="7"> MENCION EN INGENIERIA DE SOFTWARE </th>
		</tr>
		<c:forEach items="${mentionCourses}" var="course">
			<c:set var="contains" value="false" />
			<c:forEach items="${course.mentions}" var="item">
			  <c:if test="${item eq 3}">
			    <c:set var="contains" value="true" />
			  </c:if>
			</c:forEach>
			<c:if test="${contains eq 'true'}">
				<tr>
					<td>${course.code}</td>
					<td>${course.name}</td>
					<td>${course.credits}</td>
					<td>${course.theoHours}</td>
					<td>${course.pracHours}</td>
					<td>${course.laboHours}</td>
					<td>
						<c:forEach items="${course.requirements}" var="requirement">
							<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</tbody>	
</table>
<br/>
<table id="tb-curriculum-free" class="table-curriculum">
	<thead>
		<tr>
			<th colspan="7"> CURSOS ELECTIVOS LIBRES </th>
		</tr>
		<tr>
			<th rowspan="2">Codigo</th>
			<th rowspan="2">Curso</th>
			<th rowspan="2">Creditos</th>
			<th colspan="3">Horas</th>
			<th rowspan="2">Requisitos</th>	
		</tr>
		<tr>
			<th>Teoria</th>
			<th>Practica</th>
			<th>Laboratorio</th>	
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${freeCourses}" var="course">
			<tr>
				<td>${course.code}</td>
				<td>${course.name}</td>
				<td>${course.credits}</td>
				<td>${course.theoHours}</td>
				<td>${course.pracHours}</td>
				<td>${course.laboHours}</td>
				<td>
					<c:forEach items="${course.requirements}" var="requirement">
						<c:if test="${requirement ne '0'}">
								${requirement}&nbsp;
							</c:if>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>