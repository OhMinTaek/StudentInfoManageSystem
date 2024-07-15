import React from 'react';
import '../css/StudentList.css'

const StudentList = ({ students, filter, onSelectStudent }) => {
    const filteredStudents = Array.isArray(students) ?
        students.filter(student => student.name.includes(filter))
        : [];

    return (
        <div className="student-list">
            <h2>학생 목록</h2>
            {filteredStudents.length === 0 ? (
                <p>검색한 이름이 없습니다.</p>
            ) : (
                <ul>
                    {filteredStudents.map((student, index) => (
                        <li key={student.id} onClick={() => onSelectStudent(student)}>
                            {index + 1}. {student.name}
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default StudentList;
