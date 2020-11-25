import requests, json
from bs4 import BeautifulSoup

class Course:
    def __init__(self, courseID):
        self.course = courseID
        self.sections = []

    def addSection(self, section):
        self.sections.append(section)

    def __str__(self):
        rep = 'CourseID: ' + self.course + '\nSections:\n'
        for section in self.sections:
            rep +=  '\t'+section.toStr() + '\n'
        return rep
    
    def toJson(self):

        result = {
            'Course' : self.course,
            'Sections' : []
        }
        for section in self.sections:
            result['Sections'].append(section.toJson())
        return result

class Section:
    def __init__(self, number, instructor, date, startTime, endTime, building, room):
        self.number = number
        self.instructor = instructor
        self.date = date
        self.time = startTime + " to "+ endTime
        self.room = room + " at " + building

    def toStr(self):
        return 'Section: ' + self.number

    def toJson(self):
        return {
            'Number' : self.number,
            'Instructor' : self.instructor,
            'Date' : self.date,
            'Time' : self.time,
            'Room' : self.room,
        }

courses = {}

def initialize():
    url = 'https://www.douglascollege.ca/current-students/important-dates-information/exam-schedule'

    page = requests.get(url)
    htmlPage = BeautifulSoup(page.content, 'html.parser')
    table = htmlPage.find('tbody')

    currentCourse = None
    for row, element in enumerate(table):
        if (row == 0):
            continue
        data_columns = element.find_all('td')
        if len(data_columns) < 8: # for now ignoring some courses
            continue
        #read 9 columns
        try:
            section_index = 0
            if (data_columns[0].has_attr('rowspan')):
                try:
                    int(data_columns[0].text)
                except ValueError:
                    number_sections = int(data_columns[0]["rowspan"])
                    currentCourse = Course(data_columns[0].text)
                    courses[data_columns[0].text] = currentCourse
                    #courses[currentCourse] = 0
                    section_index = 1
            
            sectionNumber = data_columns[section_index].text
            instructor = data_columns[section_index+1].text
            date = data_columns[section_index+2].text
            startTime = data_columns[section_index+3].text
            endTime = data_columns[section_index+5].text
            building = data_columns[section_index+6].text
            room = data_columns[section_index+7].text

            section = Section(sectionNumber, instructor, date, startTime, endTime, building, room)
            currentCourse.addSection(section)
        except IndexError as err:
            #print(section_index)
            #print(data_columns)
            #print(err)
            continue
            
        #if currentCourse is not None:  
        #    courses[currentCourse] += 1

    #for courseID in courses:
    #    print(courses[courseID])


    #id = 'VTEC2107'
    #if id in courses:
    #    print(courses[id])
    #else:
    #    print('not found')


def getCourses():

    result = { 'Courses': [] }
    for course in courses:
        result['Courses'].append(courses[course].toJson())
    return result; #{'Courses' : json.loads(json.dumps(courses))}        

def getCourse(id):
    if isinstance(id, str):
        id = id.upper()
        if id in courses:
            return courses[id].toJson()
    
    return {'Error': 'Not found'}